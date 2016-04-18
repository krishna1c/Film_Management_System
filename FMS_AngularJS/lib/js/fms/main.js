/**
 * Created by vpatchav on 1/10/2016.
 */
var fms =  angular.module("myFMS", ['ui.router','angularUtils.directives.dirPagination']);

fms.config(function($stateProvider, $urlRouterProvider){

    $urlRouterProvider.otherwise('/home');

    $stateProvider
        .state('home', {
            url: '/home',
                templateUrl: 'template/home.html'
        })
        .state('search', {

            url: '/Search',
            templateUrl: 'template/search.html',
            controller : "SearchController"
        })
        .state('search.list', {
            url: '/list',
            templateUrl: 'template/searchresults.html',
            controller : "SearchController"

        })
        .state('search.l', {
            url: '/filmdetails',
            templateUrl: 'template/filmdetails.html',
            params: {myParam: null},
            controller : "SearchController"

        })
        .state('admin.addfilm', {
            url: '/addfilm',
            templateUrl: 'template/addfilm.html',
            params: {myParam: null},
            controller : "AddController"

        })
        .state('admin.modifyfilm', {
            url: '/modifyfilm',
            templateUrl: 'template/modifyfilm.html',
            params: {myParam: null},
            controller : "ModifyController"

        })
        .state('admin.removefilm', {
            url: '/removefilm',
            templateUrl: 'template/removefilm.html',
            params: {myParam: null},
            controller : "RemoveController"

        })
        .state('viewall', {
            url: '/viewall',
            templateUrl: 'template/viewall.html',
            params: {myParam: null},
            controller : "ViewAllController"

        })
        .state('admin', {
            url: '/admin',
            templateUrl: 'template/admin.html',
            params: {myParam: null}


        })
    //$routeProvider
    //    .when('/Home', {
    //        templateUrl : 'template/home.html',
    //        controller  : 'SearchController'
    //    })
    //    .when('/search', {
    //        templateUrl : 'template/search.html',
    //        controller  : 'SearchController'
    //    })
    //    .when('/searchresults', {
    //        templateUrl : 'template/searchresults.html',
    //        controller  : 'SearchController'
    //    })
    //    .when('/filmdetails', {
    //        templateUrl : 'template/filmdetails.html',
    //        controller  : 'SearchController'
    //    })
    //    .otherwise({
    //        redirectTo: '/Home'
    //    });

});
fms.directive("fileread", [function () {
    return {
        scope: {
            fileread: "="
        },
        link: function (scope, element, attributes) {
            element.bind("change", function (changeEvent) {
                var reader = new FileReader();
                reader.onload = function (loadEvent) {
                    scope.$apply(function () {
                        scope.fileread = loadEvent.target.result;
                    });
                }
                reader.readAsDataURL(changeEvent.target.files[0]);
            });
        }
    }
}]);