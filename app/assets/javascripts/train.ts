function checkAnswer(e : Event) {
    if (e.preventDefault) e.preventDefault();

    const incorrect = $(".incorrect");
    const correct = $(".correct");

    incorrect.hide();
    correct.hide();

    const answer = $("#answer").val();
    if ($.inArray(answer.trim().toLowerCase(), (<any>window).candidates) > -1) {
        correct.show();
        setTimeout(() => window.location.reload(false), 1500);
    } else {
        incorrect.show();
        setTimeout(() => {
            $("#answer").val("").focus();
            incorrect.hide();
        }, 2000);
    }

    return false;
}

$(() => {
    $("#checkForm").submit(checkAnswer);

    if ($("audio").length) {
        $("h2").click(() => {
            ($("audio")[0] as HTMLAudioElement).play();
            $("#answer").focus();
        });
    }
});
