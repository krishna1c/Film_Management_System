/**
 * Created by vpatchav on 1/14/2016.
 */
fms.controller('ModifyController',function($scope,service,postservice){
    console.log("In NEW controller")
    function callback(data){
        $scope.status = data;
        console.log( $scope.status)
    };
    console.log($scope.film);
    $scope.actors = [{}];
    $scope.modifyFilm = function(filmName){
        $scope.status = undefined;
        $scope.link = "http://localhost:8080/FMS_Spring_MVC/stitle";
        $scope.dummy = filmName;
        $scope.film = service(call,$scope.link,{params:{"name":$scope.dummy}});
        function call(data){
            console.log($scope.status)
            console.log($scope.film)
            $scope.film = data[0];
            if($scope.film!=undefined && $scope.film.length!=0) {
                $scope.actors = $scope.film.actors;
                $scope.status = undefined;
            }
            if($scope.film == undefined || $scope.film.length==0) {
                $scope.film = [];

                $scope.status = false;
            }
            console.log($scope.film)
            // console.log($scope.data.actors + '@@@@@@@@@@@')

        }
    };

    $scope.addActor = function() {
        var newActorNo = $scope.actors.length+1;
        $scope.actors.push({first_name:'',last_name:''});
    };

    $scope.deleteActor = function() {
        var lastActor = $scope.actors.length-1;
        $scope.actors.splice(lastActor);
    };

    $scope.addFilm = function(film){
        console.log($scope.filmName)
        console.log($scope.film);
        $scope.link = "http://localhost:8080/FMS_Spring_MVC/mfilm?tit="+$scope.filmName;
        $scope.status = postservice(callback,$scope.link,angular.toJson($scope.film))
    }
})