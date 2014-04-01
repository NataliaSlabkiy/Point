/**
 * Created by Natalia on 01.04.2014.
 */
function check(){
    var r=document.forms["form"]["R"].value;
    var y=document.forms["form"]["Y"].value;
    var x=document.forms["form"]["X"].value;

    if (r.length==0){
        document.getElementById("errorR").innerHTML="*must be filled out";
        alert("ddd");
        return false;
    }

}