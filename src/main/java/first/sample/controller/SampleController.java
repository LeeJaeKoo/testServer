package first.sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import first.sample.service.SampleService;
import net.sf.json.JSONObject;

@Controller
public class SampleController {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "sampleService")
	private SampleService sampleService;

	private static String id = null;

	// test
	@RequestMapping(value = "/sample/openSampleDataList.do")
	public ModelAndView openSampleDataList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/dataList");

		List<Map<String, Object>> list = sampleService.selectDataList(commandMap);
		mv.addObject("list", list);

		return mv;
	}

	// skip tracking
	@RequestMapping(value = "/track/skip.do")
	public ModelAndView logSkip(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/skip");
		System.out.println(id);
		sampleService.insertSkip(commandMap);
		return mv;
	}

	// start tracking
	@RequestMapping(value = "/track/start.do")
	public ModelAndView logStart(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/start");
		System.out.println(id);
		sampleService.insertStart(commandMap);
		return mv;
	}

	// firstQuartile tracking
	@RequestMapping(value = "/track/firstQuartile.do")
	public ModelAndView logfirstQuartile(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/firstQuartile");
		System.out.println(id);
		sampleService.insertfirstQuartile(commandMap);
		return mv;
	}

	// midpoint tracking
	@RequestMapping(value = "/track/midpoint.do")
	public ModelAndView logMidpoint(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/firstQuartile");
		System.out.println(id);
		sampleService.insertMidpoint(commandMap);
		return mv;
	}

	// thirdQuartile tracking
	@RequestMapping(value = "/track/thirdQuartile.do")
	public ModelAndView logThirdQuartile(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/firstQuartile");
		System.out.println(id);
		sampleService.insertThirdQuartile(commandMap);
		return mv;
	}

	// complete tracking
	@RequestMapping(value = "/track/complete.do")
	public ModelAndView logComplete(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/firstQuartile");
		System.out.println(id);
		sampleService.insertComplete(commandMap);
		return mv;
	}

	// rewind tracking
	@RequestMapping(value = "/track/rewind.do")
	public ModelAndView logRewind(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/firstQuartile");
		System.out.println(id);
		sampleService.insertRewind(commandMap);
		return mv;
	}

	// resume tracking
	@RequestMapping(value = "/track/resume.do")
	public ModelAndView logResume(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/firstQuartile");
		System.out.println(id);
		sampleService.insertResume(commandMap);
		return mv;
	}

	// progress tracking offset GET 방식으로 받아와 insert
	@RequestMapping(value = "/track/progress.do")
	public ModelAndView logProgress(HttpServletRequest req) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/firstQuartile");
		Object offset = req.getParameter("offset");
		System.out.println(id);
		sampleService.insertProgress(offset.toString());
		return mv;
	}

	// [VAST] 프리롤 시킵 불가
	@RequestMapping(value = "/server/preroll_no_skip.do", method = RequestMethod.GET)
	public String preroll_no_skip(HttpServletRequest req, HttpServletResponse res) {
		id = req.getParameter("mediaID");
		String screenCode = req.getParameter("screenCode");
		String adType = req.getParameter("adType");
		System.out.println("================ " + id + ", " + screenCode + ", " + adType + "==========================");
		return "server/preroll_no_skip";
	}

	// [VAST] 프리롤 스킵가능
	@RequestMapping(value = "/server/preroll_skip", method = RequestMethod.GET)
	public String preroll_skip(HttpServletRequest req, HttpServletResponse res) {
		id = req.getParameter("mediaID");
		String screenCode = req.getParameter("screenCode");
		String adType = req.getParameter("adType");
		System.out.println("================ " + id + ", " + screenCode + ", " + adType + "==========================");

		return "server/preroll_skip";
	}

	// [VAST] 포스트 롤 스킵가능 VMAP 활용
	@RequestMapping(value = "/server/postroll", method = RequestMethod.GET)
	public String postroll(HttpServletRequest req, HttpServletResponse res) {
		id = req.getParameter("mediaID");
		String screenCode = req.getParameter("screenCode");
		String adType = req.getParameter("adType");
		System.out.println("================ " + id + ", " + screenCode + ", " + adType + "==========================");
		return "server/postroll";
	}

	// [VAST] 미드롤 스킵가능 VMAP 활용
	@RequestMapping(value = "/server/midroll", method = RequestMethod.GET)
	public String midroll(HttpServletRequest req, HttpServletResponse res) {
		id = req.getParameter("mediaID");
		String screenCode = req.getParameter("screenCode");
		String adType = req.getParameter("adType");
		System.out.println("================ " + id + ", " + screenCode + ", " + adType + "==========================");
		return "server/midroll";
	}

	// [VAST] 프리롤 스킵가능 XML 활용
	@RequestMapping(value = "/server/preroll", method = RequestMethod.GET)
	public String preroll(HttpServletRequest req, HttpServletResponse res) {
		id = req.getParameter("mediaID");
		String screenCode = req.getParameter("screenCode");
		String adType = req.getParameter("adType");
		System.out.println("================ " + id + ", " + screenCode + ", " + adType + "==========================");
		res.setHeader("Access-Control-Allow-Origin", "*");
		return "server/preroll";
	}

	// JSONP 콜백함수
	@RequestMapping(value = "getData", method = RequestMethod.GET)
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String callBack = req.getParameter("myCallback");
		System.out.println("================ " + id + "==========================");

		JSONObject obj = new JSONObject();
		obj.put("result", id);
		obj.put("go", "테스트");

		PrintWriter out = res.getWriter();
		out.write(callBack + "(" + obj.toString() + ")");
		System.out.println(callBack + "(" + obj.toString() + ")");
		out.flush();
		out.close();
	}

}
