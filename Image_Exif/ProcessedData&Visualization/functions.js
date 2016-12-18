
function capitalize(string) {
    return string.charAt(0).toUpperCase() + string.slice(1).toLowerCase();
}


function maxKey(obj) {
    var max_yr = -1, max_cnt = -1;
    for (var i = 0; i < obj.length; i++) {
        if(obj[i]['y'] > max_cnt){
            max_cnt = obj[i]['y']
            max_yr = obj[i]['x']
        }
    }
    return max_yr;
}

function maxValue(obj){
    var max_cnt = -1;
    for(var i = 0; i < obj.length; i++){
        if(obj[i]['y'] > max_cnt){
            max_cnt = obj[i]['y']
        }
    }
    return max_cnt;
}

function sort_wrt_year(obj){
    return obj.sort(function(a,b) {return (a.x > b.x) ? 1 : ((b.x > a.x) ? -1 : 0);} ); 
}

function sumd( year_arr ) {
    var total = 0;

    for(var i = 0; i < year_arr.length; i++)
        total += parseInt( year_arr[i]['y'] );
    
//    console.log(total + obj)
    return total;
}
