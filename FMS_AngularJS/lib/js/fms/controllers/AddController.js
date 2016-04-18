/**
 * Created by vpatchav on 1/14/2016.
 */
fms.controller('AddController',function($scope,service,postservice){
    console.log("In controller")
    $scope.actors = [{}];
    function callback(data){
        $scope.status = data;
        console.log( $scope.status)
    };
    $scope.addNewActor = function() {
        var newActorNo = $scope.actors.length+1;
        $scope.actors.push({});
    };

    $scope.removeActor = function() {
        var lastActor = $scope.actors.length-1;
        $scope.actors.splice(lastActor);
    };
    $scope.addFilm = function(film,actors){
        console.log("In Funciton")
        $scope.film.actors=actors;
        console.log($scope.film);
        $scope.link = "http://localhost:8080/FMS_Spring_MVC/sfilm";
        $scope.status = postservice(callback,$scope.link,angular.toJson($scope.film))
        //$http.post( $scope.link,angular.toJson($scope.film)).then(
        //    function (response) {
        //       callback(response.data);
        //        // not relevant
        //    }, function (error) {
        //        callback(false);
        //        // not relevant
        //    });

    }
})