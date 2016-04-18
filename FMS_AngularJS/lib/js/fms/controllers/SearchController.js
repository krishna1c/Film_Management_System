/**
 * Created by vpatchav on 1/10/2016.
 */
fms.controller("SearchController", function ($scope,$http,$state,service,$stateParams) {
    console.log(1)
    console.log($scope.view)
    $scope.film=$stateParams.myParam;
    function callback(data){
        $scope.view = data;
        console.log(data)
    };
    $scope.vam=function(s){
        console.log(s);
    }
    $scope.searchL= function(title,actor,rating,language,category){
        $scope.view = undefined;
        $scope.dummy = language;
        $scope.link = "http://localhost:8080/FMS_Spring_MVC/hello";
        if(title.length!=0) {
            $scope.link = "http://localhost:8080/FMS_Spring_MVC/stitle";
            $scope.dummy = title;
        }
        else if(actor.length!=0){
            $scope.link = "http://localhost:8080/FMS_Spring_MVC/sactor";
            $scope.dummy = actor;
        }
        else if(rating.length!=0){
            $scope.link = "http://localhost:8080/FMS_Spring_MVC/srating";
            $scope.dummy = rating;
        }
        else if(language.length!=0){
            $scope.link = "http://localhost:8080/FMS_Spring_MVC/slanguage";
            $scope.dummy = language;
        }
        else if(category.length!=0){
            $scope.link = "http://localhost:8080/FMS_Spring_MVC/scategory";
            $scope.dummy = category;
        }
        $scope.view = service(callback,$scope.link,{params:{"name":$scope.dummy}});
        $state.go("search.list");
    }

});


fms.filter('titlecase', function() {
    return function (input) {
        var smallWords = /^(a|an|and|as|at|but|by|en|for|if|in|nor|of|on|or|per|the|to|vs?\.?|via)$/i;

        input = input.toLowerCase();
        return input.replace(/[A-Za-z0-9\u00C0-\u00FF]+[^\s-]*/g, function(match, index, title) {
            if (index > 0 && index + match.length !== title.length &&
                match.search(smallWords) > -1 && title.charAt(index - 2) !== ":" &&
                (title.charAt(index + match.length) !== '-' || title.charAt(index - 1) === '-') &&
                title.charAt(index - 1).search(/[^\s-]/) < 0) {
                return match.toLowerCase();
            }

            if (match.substr(1).search(/[A-Z]|\../) > -1) {
                return match;
            }

            return match.charAt(0).toUpperCase() + match.substr(1);
        });
    }
});
