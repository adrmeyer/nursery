<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>off day</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body>

        Day: <input type="date" id="day" required="required" name="day"><br>
        Half day: <input type="text" id="halfDay" required="required" name="halfDay"><br>
        <button onclick="submit();">Submit</button>
     
     
    <script type="text/javascript">
    data = "";
    submit = function(){
          
            $.ajax({
                url:'saveOrUpdate',
                type:'POST',
                data:{day:$("#day").val(),period:$('#halfDay').val(),off_day:"1"},
                success: function(response){
                        alert(response.message);
                        load();    
                }              
            });        
    }
         
    </script>
</body>
</html>