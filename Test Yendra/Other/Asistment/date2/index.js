function lifetimer() {

    today = new Date()

    BirthDay = new Date(document.live.age.value)

    timeold = (today.getTime() - BirthDay.getTime());

    sectimeold = timeold / 1000;

    secondsold = Math.floor(sectimeold);

    msPerDay = 24 * 60 * 60 * 1000;

    timeold = (today.getTime() - BirthDay.getTime());

    e_daysold = timeold / msPerDay;

    daysold = Math.floor(e_daysold);

    e_hrsold = (e_daysold - daysold) * 24;

    hrsold = Math.floor(e_hrsold);

    minsold = Math.floor((e_hrsold - hrsold) * 60);

    document.live.time1.value = daysold

    document.live.time2.value = hrsold

    document.live.time3.value = minsold

    window.status = "Well at the moment you are " + secondsold + "............ seconds old.";

    timerID = setTimeout("lifetimer()", 1000)

}