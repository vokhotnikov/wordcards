/**
 * Created by hunter on 15/12/2016.
 */

function checkAnswer(e) {
    if (e.preventDefault) e.preventDefault();

    $(".incorrect").hide();
    $(".correct").hide();

    var answer = $("#answer").val();
    if ($.inArray(answer.trim().toLowerCase(), window.candidates) > -1) {
        $(".correct").show();
        setTimeout(function(){ window.location.reload(false); }, 1500);
    } else {
        $(".incorrect").show();
        setTimeout(function(){
            $("#answer").val("").focus();
            $(".incorrect").hide();
        }, 2000);
    }

    return false;
}

$(function() {
    $("#checkForm").submit(checkAnswer);

    if ($("audio").length) {
        $("h2").click(function(){
            $("audio")[0].play();
        });
    }
});
