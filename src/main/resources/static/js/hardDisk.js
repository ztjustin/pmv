/**
 * Created by justin Zuniga Torres
 */



$( document ).ready(function() {

	
/*Fisrt method*/	
	
$("#hardDiskId").change(function(){
	 
	 
	 var hardDiskId = $('#hardDiskId option:selected').val();

	 
	 $.ajax({
		 
		    type: "GET",
		    cache: false,
		    url: "/admin/getOneHardDisk",
		    data: { 
		        'hardDiskId': hardDiskId
		    }, // Adjuntar los campos del formulario enviado.

		    success: function(data)
		     {
		    	$("#operatingSystem").val(data.operatingSystem.nameSystem);
		    	$("#typeSystem").val(data.operatingSystem.typeSystem);
		     }
	});
	 
	 
 });

});
