/**
 * Created by vpatchav on 1/10/2016.
 */
fms.controller("ViewAllController", function ($scope,$http,$state,service,$stateParams) {
    console.log(1)
    console.log($scope.view)
    function callback(data){
        $scope.view = data;
        console.log(data)
    };

    $scope.view = undefined;

    $scope.link = "http://localhost:8080/FMS_Spring_MVC/gfilm";
    $scope.view = service(callback,$scope.link,{params:{}});

});

