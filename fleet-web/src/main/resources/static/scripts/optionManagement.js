var removeClickFunction = function (e) {
    e.preventDefault();

    var selectedOption = $(this).parents('.optionRow');
    var optionId = selectedOption.find(".optionId").val();

    var listBox = $('#globalOptionsListBox');

    var removedOption = $('<option></option>');

    var optionName = selectedOption.find(".optionName").html();

    removedOption.html(optionName);
    removedOption.attr('data-option-id', optionId);
    listBox.append(removedOption);

    selectedOption.remove();
};

var checkBoxChangeFunction = function () {
    if ($(this).is(":checked")) {
        $(this).parent().find('.optionDefaultHidden').attr('value', true);
    }
    else {
        $(this).parent().find('.optionDefaultHidden').attr('value', false);
    }
};

var addOptionToCarModelFunction = function (e, optionId, optionNameString) {
    e.preventDefault();
    $.get("/html/optionrow.html", function (data) {

        $('#optionTableBody').append(data);
        optionAdded = $('#optionTableBody').children().last();

        var optionNameInput = optionAdded.find('.optionName');
        var optionIdInput = optionAdded.find('.optionId');
        var optionDefault = optionAdded.find('.optionDefaultCheckBox');
        var optionDefaultHidden = optionAdded.find('.optionDefaultHidden');

        optionNameInput.html(optionNameString);
        optionIdInput.attr('value', optionId);
        optionDefault.attr('checked', false);
        optionDefaultHidden.attr('value', false);

        $('.removeOptionBtn').click(removeClickFunction);
        $('.optionDefaultCheckBox').change(checkBoxChangeFunction);
    });
};

$(document).ready(function () {

    $('#addOptionBtn').click(function (e) {
        var selectedOpts = $('#globalOptionsListBox option:selected');

        if (selectedOpts.length == 0) {
            console.log("Nothing to move.");
        }
        else
        {
            var optionName = selectedOpts.html();
            var optionId = selectedOpts.attr('data-option-id');

            addOptionToCarModelFunction(e, optionId, optionName);

            $(selectedOpts).remove();
        }
    });

    $('.removeOptionBtn').click(removeClickFunction);

    $('.optionDefaultCheckBox').change(checkBoxChangeFunction);
});
