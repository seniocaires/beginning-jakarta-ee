package book.jakarta8.wsdate_client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

import book.jakarta8.wsdate.generated.WsDate;
import book.jakarta8.wsdate.generated.WsDateService;

/*
 * Para resolver os imports:
 * import book.jakarta8.wsdate.generated.WsDate;
 * import book.jakarta8.wsdate.generated.WsDateService;
 * 
 * Run As... > Maven build... > goals “jaxws:wsimport.”
 * 
 * Acesse:
 * http://localhost:8080/n-009-wsdate-client/WsDateServlet
 * 
 * 
 * If, for whatever reason, you need to process XML data directly, outside JAX-WS, Jakarta
 * EE 8 also includes several technologies to create and parse XML data:
 * - JAXP 1.6
 * Java API for XML Processing
 * - StAX 1.0
 * Streaming API for XML. Included within JAXP.
 * - JAXB 2.2
 * Java XML Binding
 */
@WebServlet(name = "WsDateServlet", urlPatterns = { "/WsDateServlet" })
public class WsDateServlet extends HttpServlet {

	private static final long serialVersionUID = -1651237748783635642L;

	@WebServiceRef(wsdlLocation = "http://localhost:8080/n-008-wsdate/WsDateService?wsdl")
	private WsDateService service;

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			out.println("<html lang=\"en\">");
			out.println("<head>");
			out.println("<title>Servlet WsDateServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet WsDateServlet at " + request.getContextPath() + "</h1>");
			out.println("<p>" + date("yyyy-MM-dd HH:mm:ss") + "</p>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private String date(String dateFormat) {
		WsDate port = service.getWsDatePort();
		return port.date(dateFormat);
	}
}
