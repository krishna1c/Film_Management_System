/**
 * Created by vpatchav on 12/22/2015.
 */
waste.controller("wastecontrol",function ($scope){
    $scope.text="Message";
    $scope.upper = function(){
        $scope.text=$scope.text.toUpperCase();
    };
}
    );