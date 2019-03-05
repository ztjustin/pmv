/**
 * Created by justin Zuniga Torres for PMV
 */


$( document ).ready(function() {
	
	var hardDiskId;
	var platformDetailId;
	
	$('#ModalOnHold').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget) // Button that triggered the modal
		  hardDiskId = button.data('harddiskid');
		  platformDetailId = button.data('platformdetailid');// Extract info from data-* attributes
		  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		  //var modal = $(this);
		  //modal.find('.modal-title').text('New message to ' + hardDiskId + " " + platformDetailId);	
		  $("#hardDiskId").val(hardDiskId);
		  $("#platformDetailId").val(platformDetailId);
	});
	
	$( "#ChangeToOnPlatform" ).click(function() {
		
		$( "#change" )[0].submit();
		 
	});
	

	

});