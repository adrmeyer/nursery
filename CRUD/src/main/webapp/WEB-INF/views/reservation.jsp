<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="load();">
	  
	  <input type="hidden" id="reservationId">
        Day: <input type="date" id="day" required="required" name="day"><br>
        Half day: <input type="text" id="halfDay" required="required" name="halfDay"><br>
        <button onclick="submit();">Submit</button>
 
        <table id="table" border=1>
            <tr> 
            	<th> Day </th> 
            	<th> Half day </th>
            	<th> Contract </th>
            	<th> Absent </th>
            	<th> Justification </th>
            	<th> Check Absent </th>
            	<th> Delete </th>
            </tr>
         
        </table>
             
     
    <script type="text/javascript">
    data = "";
    submit = function(){
          
            $.ajax({
                url:'saveOrUpdate',
                type:'POST',
                data:{reservationId:$("#reservationId").val(),day:$('#day').val(),halfDay:$('#halfDay').val()},
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
            data:{reservationId:id},
            success: function(response){
                    alert(response.message);
                    load();
            }              
        });
}
     
 
    edit = function (index){
        $("#reservationId").val(data[index].reservationId);
        $("#day").val(data[index].day);
        $("#halfDay").val(data[index].halfDay);
         
    }

    checkAbsent = function(id) {
        $.ajax({
			url:'saveOrUpdate',
			type:'POST',
			data:{reservationId:id},
			success: function(response){
					alert(response.message);
					load();	
			}
        });
    }
     
     
    load = function(){ 
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){                  
                        $("#table").append("<tr class='tr'> <td> "+response.data[i].day+" </td> <td> "+response.data[i].halfDay+"</td> <td> LinkContract </td> <td> "+ response.data[i].absent +"</td><td>" + response.data[i].justification +"</td> <td> <a href='#' onclick='checkAbsent_("+response.data[i].reservationId");'> Check Absent </a> </td> <td> <a href='#' onclick='delete_("+response.data[i].user_id+");'> Delete </a>  </td> </tr>");
                    }          
            }              
        });
         
    }
         
    </script>
</body>
</html>