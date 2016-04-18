/**
 * Created by vpatchav on 1/15/2016.
 */
fms.service("postservice", function ($http) {
   return function (callback,urllink,jsonfile) {
       $http.post(urllink, jsonfile).then(
           function (response) {
               callback(response.data);
               // not relevant
           }, function (error) {
               callback(false);
               // not relevant
           });
   }
})