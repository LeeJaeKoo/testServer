package first.sample.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import first.sample.dao.SampleDAO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "sampleDAO")
	private SampleDAO sampleDAO;

	@Override
	public List<Map<String, Object>> selectDataList(Map<String, Object> map) throws Exception {
		return sampleDAO.selectDataList(map);

	}

	@Override
	public void insertSkip(Map<String, Object> map) throws Exception {
		sampleDAO.insertSkip(map);
	}

	@Override
	public void insertStart(Map<String, Object> map) throws Exception {
		sampleDAO.insertStart(map);

	}

	@Override
	public void insertfirstQuartile(Map<String, Object> map) throws Exception {
		sampleDAO.insertFirstQuartile(map);

	}

	@Override
	public void insertMidpoint(Map<String, Object> map) {

		sampleDAO.insertMidpoint(map);

	}

	@Override
	public void insertThirdQuartile(Map<String, Object> map) {

		sampleDAO.insertThirdQuartile(map);

	}

	@Override
	public void insertComplete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sampleDAO.insertComplete(map);
	}

	@Override
	public void insertProgress(String offset) {
		sampleDAO.insertProgress(offset);

	}

	@Override
	public void insertRewind(Map<String, Object> map) {
		sampleDAO.insertRewind(map);

	}

	@Override
	public void insertResume(Map<String, Object> map) {
		sampleDAO.insertResume(map);

	}

}
