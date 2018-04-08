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
        $("#contractType").val(data[index].contractType);
        $("#startingDate").val(data[index].startingDate);
        $("#endingDate").val(data[index].endingDate);
        $("#childcarePrice").val(data[index].childcarePrice);
        $("#legalTutor").val(data[index].legalTutor);
        $("#legalTutorPhone").val(data[index].legalTutorPhone);
        $("#childId").val(data[index].childId);
    }
     
     
    load = function(){ 
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){                  
                        $("#table").append("<tr class='tr'> <td> linkChild </td> <td> " + response.data[i].contractType +"</td> <td>"+ response.data[i].startingDate +"</td> <td>"+ response.data[i].endingDate +"</td> <td>"+ response.data[i].chilcarePrice +"</td> <td>"+ response.data[i].legalTutor +"</td> <td>"+ response.data[i].legalTutorPhone +"</td> <td> LinkReservations </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].user_id+");'> Delete </a>  </td> </tr>");
                    }          
            }              
        });
         
    }
         
    </script>
     
</body>
</html>