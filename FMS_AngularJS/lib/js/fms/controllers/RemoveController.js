/**
 * Created by vpatchav on 1/14/2016.
 */
fms.controller('RemoveController',function($scope,service,$http) {
    $scope.removefilm=function(rfilm){
        $scope.link = "http://localhost:8080/FMS_Spring_MVC/stitle";
        $scope.dummy = rfilm;
        $scope.data = service(callback,$scope.link,{params:{"name":$scope.dummy}});
        function callback(film){
            $scope.data = film;
            if($scope.data == undefined)
                $scope.data = [];
            console.log($scope.data)
        if($scope.data.length==0){
                $scope.view=false;
            }
            // console.log($scope.data.actors + '@@@@@@@@@@@')

        }
    }
    function callback(data){
        $scope.view = data;
        console.log(data)
        if($scope.view==true)
        {}

    };
    $scope.deletefilm=function(name){
        $scope.link = "http://localhost:8080/FMS_Spring_MVC/rfilm";
        $scope.dummy = name;
        $scope.view = service(callback,$scope.link,{params:{"name":$scope.dummy}});

    }
})