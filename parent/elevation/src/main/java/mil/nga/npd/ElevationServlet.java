package mil.nga.npd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mil.nga.npd.exceptions.InternalServerErrorException;
import mil.nga.npd.exceptions.InvalidParameterException;

/**
 * Servlet implementation class ElevationServlet
 */
public class ElevationServlet extends HttpServlet {
       
    /**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1362017254027371112L;

	/**
	 * Default no-arg constructor.
     * @see HttpServlet#HttpServlet()
     */
    public ElevationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("unchecked")
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
        try {
            String responseStr = new ElevationRESTFilter.ElevationRESTFilterBuilder()
                    .withParameterMap(request.getParameterMap())
                    .build()
                    .translate();
            response.getWriter().println(responseStr);
        }
        catch (InternalServerErrorException ise) {
            // Sends an HTTP 500 error back to the caller.
            throw new ServletException(ise.getMessage());
        }
        catch (InvalidParameterException ipe) {
            // Sends an HTTP 400 (bad request) error back to the caller.
            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST, 
                    ipe.getMessage());
        }
	}

	/**
	 * Forward POST request the GET method.
     * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
