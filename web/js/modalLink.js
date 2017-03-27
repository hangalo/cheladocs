/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function apresentarModal(url)
{
    $(document).ready(function () {
        $('#modal_link').click(function () {
            $('.modal-container').load(url, function () {
                $('#myModal').modal({show: true});
            });
        });
    });
}

