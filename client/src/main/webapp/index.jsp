<!doctype html>
<html ng-app>
    <head>
        <title>Get Places</title>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular.min.js"></script>
   </script>
        <script src="restGetPlaces.js"></script>
          <script src="http://maps.google.com/maps/api/js?sensor=false" 
          type="text/javascript"></script>
        
    </head>

    <body>
        <div ng-controller="GetPlaces">
            <table class="table table-striped">
                <tr ng-repeat="place in places">
                    <td>Latitude: {{place.latitude}}</td>
                    <td>Longitude: {{place.longitude}}</td>
                </tr>
            </table>
            <div id="map" style="width: 500px; height: 400px;"></div>
            <button ng-click="saveMarker()">Save new position</button>
        </div>
    </body>
</html>