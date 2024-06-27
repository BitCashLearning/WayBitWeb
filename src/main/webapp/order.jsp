<%@ page import = "us.bitcash.apps.waybitweb.domain.MenuItem" %>
<%@ page import = "java.util.List" %>

<html>
    <body>
    <h1>Ricky's Restaurant</h1>
    <h2>Order your food:</h2>
    
        <jsp:include page="/header.jsp" />
        
        <form action='/orderReceived.html' method='POST'>
       		<%
       		List<MenuItem> menuItems = (List<MenuItem>)request.getAttribute("menuItems");
       		
       		for (MenuItem item : menuItems) {
       		%>
       		
       		<li><%=item%></li>
			<label>
				<input type='text' name=<%="item_"+item.getId()%> />
			</label>

			<%
       		}
       		%>
        	
        	<input type='submit'/>
        
        </form>

        <jsp:include page="/footer.jsp" />

    </body>

</html>