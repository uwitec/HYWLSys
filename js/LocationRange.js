$(function () {

    $(".area-select").each(function () {
        var area = $(this).areaselect({
            source: EXPRESS.areaData,
            grade: 3,
            type: 'source',
            showIn: $(this).prev(),
            after: function (element) {
                element.areaselect('close');
            }
        })
        .hide();
    });

    $('html').bind("click", function (event) {
        var target = $(event.target);
        var parent = target.parent();
        if (!parent.is('.area-wraper')) {
            $(".area-select").hide();
        }
        else {
           $(".area-select").not(parent.find(".area-select")).hide();
        }
    });
});