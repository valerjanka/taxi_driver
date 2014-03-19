function GetPlaces($scope, $http) {
	$scope.places = [];
	
	var map = new google.maps.Map(document.getElementById('map'), {
		zoom : 5,
		center : new google.maps.LatLng(20, 10),
		mapTypeId : google.maps.MapTypeId.ROADMAP
	});

	var infowindow = new google.maps.InfoWindow();

	google.maps.event.addListener(map, 'click', function(event) {
		placeMarker(event.latLng);
	});
	
	function loadPlaces() {
		$http.get('http://localhost:8080/TD_server/rest/place/user/1').success(
				function(data) {
					$scope.places = data;
					updateMap();
				});
		
	}	
	
	$scope.saveMarker = function() {
		var place = {user:{id:1}, longitude: $scope.marker.longitude, latitude:$scope.marker.latitude, time:null};
		alert(place);
		$http.put('http://localhost:8080/TD_server/rest/place', place);
		loadPlaces();
	}
	
	function placeMarker(location) {
		if ($scope.marker) {
			$scope.marker.setPosition(location);
		} else {
			$scope.marker = new google.maps.Marker({
				position : location,
				map : map
			});
		}
	}

	function updateMap() {
		var marker, i;
		for (i = 0; i < $scope.places.length; i++) {
			marker = new google.maps.Marker({
				position : new google.maps.LatLng($scope.places[i].latitude,
						$scope.places[i].longitude),
				map : map
			});

			google.maps.event.addListener(marker, 'click',
					(function(marker, i) {
						return function() {
							infowindow.setContent($scope.places[i].id);
							infowindow.open(map, marker);
						}
					})(marker, i));
		}
	}
	
	loadPlaces();
}
