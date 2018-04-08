<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contract Reservations</title>
</head>
<body onload="load();">
	<table id="table" border=1>
            <tr> <th>id</th> <th> Absent </th> <th> Justification </th> <th> date </th> <th> Edit </th> <th> Delete </th> </tr>
         	
    </table>
    
    <script type="text/javascript">
    data = ${reservation}
    load = function(){
    	for(i=0; i<data.length; i++){                  
            $("#table").append("<tr class='tr'> <td> "+ data[i].id+" </td> <td> "+ data[i].absent +" </td> <td> "+ data[i].justification" </td> <td> "+ data[i].halfday.date" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+ data[i].id +");'> Delete </a>  </td> </tr>");
        }   
        }
    </script>
</body>
</html>