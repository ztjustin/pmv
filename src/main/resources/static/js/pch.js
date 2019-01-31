/**
 * Created By Justin Zuniga Torres
 */

$( document ).ready(function() {

		
 $("#pchVisualId").change(function(){
	 
	 
	 var pchId = $('#pchVisualId option:selected').val();
	 
	 $.ajax({
		 
		    type: "GET",
		    cache: true,
		    url: "/admin/getOnePch",
		    data: { 
		        'pchId': pchId
		    }, // Adjuntar los campos del formulario enviado.

		    success: function(data)
		     {
		      //Actualiza valores por defecto
		       $("#qdf").val(data.qdf); 
		       $("#pchName").val(data.pchName);
		     }
	});
	 
	 
 });
 
 
 $(".pchVisualId").chosen();

});
