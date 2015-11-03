$(document).ready(function(){
    $('.gridCell').responsiveEqualHeightGrid();

    var category = $('#categoryInput');

    retrieveCarModels();

    category.on('change', retrieveCarModels());

    function retrieveCarModels() {
        console.log('retrieveCarModels');

        var url = '/carmodels';

        if (category.val() != '') {
            url = url + '/' + category.val();
        }

        $("#carModelGrid").load(url);
    }
});
