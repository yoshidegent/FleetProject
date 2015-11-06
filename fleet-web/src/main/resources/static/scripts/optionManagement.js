$(document).ready(function () {

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

    var checkBockChangeFunction = function() {
        if($(this).is(":checked")) {
            $('.optionDefaultHidden').attr('value', true);
        }
        else {
            $('.optionDefaultHidden').attr('value', false);
        }
    };

    $('#addOptionBtn').click(function (e) {
        var selectedOpts = $('#globalOptionsListBox option:selected');

        e.preventDefault();

        if (selectedOpts.length == 0) {
            console.log("Nothing to move.");
        }
        else {

            $.get("/html/optionrow.html", function(data){

                $('#optionTableBody').append(data);
                optionAdded = $('#optionTableBody').children().last();

                var optionId = selectedOpts.attr('data-option-id');

                var optionName = optionAdded.find('.optionName');
                var optionDefault = optionAdded.find('.optionDefaultCheckBox');
                var optionDefaultHidden = optionAdded.find('.optionDefaultHidden');
                var optionIdInput = optionAdded.find('.optionId');

                optionName.html(selectedOpts.html());
                optionIdInput.attr('value', optionId);
                optionDefault.attr('checked', false);
                optionDefaultHidden.attr('value', false);

                $(selectedOpts).remove();

                optionAdded.find('.removeOptionBtn').click(removeClickFunction);
                optionAdded.find('.optionDefaultCheckBox').change(checkBockChangeFunction);
            });
        }
    });


    $('.removeOptionBtn').click(removeClickFunction);

    $('.optionDefaultCheckBox').change(checkBockChangeFunction);
})
