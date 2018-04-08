<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contract</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="load();">


 	<input type="hidden" id="contract_id">
        Child: <select id="child"> 
        	<option>--Select Options--</option>
        </select><br>
        Contract Type: <input type="text" id="contract_type" required="required" name="contract_type"><br>
    	Starting Date: <input type="date" id="starting_date" required="required" name="starting_date"><br>
    	Ending Date: <input type="date" id="ending_date" required="required" name="ending_date"><br>
    	Childcare Price: <input type="number" id="childcare_price" required="required" name="childcare_price"><br>
    	Legal Tutor: <input type="text" id="legal_tutor" required="required" name="legal_tutor"><br>
    	Legal Tutor Phone: <input type="text" id="tutor_phone" required="required" name="tutor_phone"><br>
     <button onclick="submit();">Submit</button>

	<table id="table" border=1>
    	<tr>
    		<th> Child </th>
    		<th> Contract type </th>
    		<th> Starting date </th>
    		<th> Ending date </th>
    		<th> Childcare Price </th>
    		<th> Legal tutor </th>
    		<th> Legal tutor phone </th>
    		<th> Reservations </th>
    		<th> Edit </th>
    		<th> Delete </th>
    	</tr>
    </table>
    
    
    
   	         
     
    <script type="text/javascript">
    data = "";

    submit = function(){
        
        $.ajax({
            url:'saveOrUpdate',
            type:'POST',
            data:{id:$("#contract_id").val(),child:$('#child').val(),contractType:$('#contract_type').val(),startingDate:$('#starting_date').val(),endingDate:$('#ending_date').val(),childcarePrice:$('#childcare_price').val(),legalTutor:$('#legal_tutor').val(),legalTutorPhone:$('#tutor_phone').val()},
            success: function(response){
                    alert(response.message);
                    load();    
            }              
        });        
}
    
    delete_ = function(id){     
         $.ajax({
            url:'delete',
            type:'POST',
            data:{id:id},
            success: function(response){
                    alert(response.message);
                    load();
            }              
        });
}
     
 
    edit = function (index){
        $("#id").val(data[index].id);
        $("#child").val(data[index].child);
        $("#contractType").val(data[index].contractType);
        $("#startingDate").val(data[index].startingDate);
        $("#endingDate").val(data[index].endingDate);
        $("#childcarePrice").val(data[index].childcarePrice);
        $("#legalTutor").val(data[index].legalTutor);
        $("#legalTutorPhone").val(data[index].legalTutorPhone);
    }
     
     
    load = function(){ 
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){                  
                        $("#table").append("<tr class='tr'> <td> "+response.data[i].child.name+" "+response.data[i].child.familyName+" </td> <td> " + response.data[i].contractType +"</td> <td>"+ response.data[i].startingDate +"</td> <td>"+ response.data[i].endingDate +"</td> <td>"+ response.data[i].chilcarePrice +"</td> <td>"+ response.data[i].legalTutor +"</td> <td>"+ response.data[i].legalTutorPhone +"</td> <td> <a href='/showReservation/"+ response.data[i].id +">Reservations</a> </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].user_id+");'> Delete </a>  </td> </tr>");
                    }          
            }              
        });
         
    }
         
    </script>
     
</body>
</html>