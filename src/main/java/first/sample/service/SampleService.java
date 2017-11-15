package first.sample.service;

import java.util.List;
import java.util.Map;

public interface SampleService {

	List<Map<String, Object>> selectDataList(Map<String, Object> map) throws Exception;

	void insertSkip(Map<String, Object> map) throws Exception;

	void insertStart(Map<String, Object> commandMap) throws Exception;

	void insertfirstQuartile(Map<String, Object> commandMap) throws Exception;

	void insertMidpoint(Map<String, Object> commandMap);

	void insertThirdQuartile(Map<String, Object> commandMap);

	void insertComplete(Map<String, Object> commandMap);

	void insertProgress(String offset);

	void insertRewind(Map<String, Object> commandMap);

	void insertResume(Map<String, Object> commandMap);

}
