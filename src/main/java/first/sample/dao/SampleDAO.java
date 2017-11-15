package first.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import first.common.dao.AbstractDAO;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectDataList(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("sample.selectDataList", map);
	}

	public void insertSkip(Map<String, Object> map) throws Exception {
		insert("sample.insertSkip", map);
	}

	public void insertStart(Map<String, Object> map) throws Exception {
		insert("sample.insertStart", map);
	}

	public void insertFirstQuartile(Map<String, Object> map) {
		insert("sample.insertFirstQuartile", map);
	}

	public void insertMidpoint(Map<String, Object> map) {
		insert("sample.insertMidpoint", map);

	}

	public void insertThirdQuartile(Map<String, Object> map) {
		insert("sample.insertThirdQuartile", map);

	}

	public void insertComplete(Map<String, Object> map) {
		insert("sample.insertComplete", map);

	}

	public void insertProgress(String offset) {
		insert("sample.insertProgress", offset);

	}

	public void insertRewind(Map<String, Object> map) {
		insert("sample.insertRewind", map);

	}

	public void insertResume(Map<String, Object> map) {
		insert("sample.insertResume", map);

	}

}
