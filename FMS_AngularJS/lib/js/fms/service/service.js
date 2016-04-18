/**
 * Created by vpatchav on 1/10/2016.
 */
fms.service("service", function ($http) {
    return function(callback,link,dummy){
        $http.get(link,dummy).then(function (resp){
            callback(resp.data);

        },function (resp) {
            callback([]);
        })
    }

});