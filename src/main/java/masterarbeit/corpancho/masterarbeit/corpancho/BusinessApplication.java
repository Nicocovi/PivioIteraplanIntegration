package masterarbeit.corpancho.masterarbeit.corpancho;

public class BusinessApplication {
	
	//Pivio
	private String externalId;
	private String name;
	private String short_name;
	private String type; //enum
	private String owner;
	private String description;
	//Jira
	private String businessDomain;
	private String critial; //enum
	private String jiraURL;
	//Cloud
	private String status; //enum
	private String technicalResponsible;
	private String jenkinsURL;
	private String deploymentDate;
	private String lastChanges;
	private String deploymentUser;
	private String platform; //enum
	private String ipAddress;
	private String port;
	//Application Performance metrics
	private String http_requests;
	private String http_request_duration;	
	
	//Map<String, String> vars = new HashMap<String, String>(); für weitere Attribute?
	
	public String toString() {
		return "{ "
					//"\"ExternalId\": [\""
					//+this.id+"\"], "
					+" \"name\": [\""
					+this.name+"\"] "
					//+ "\"Owner\": ["
					//+this.owner+"]"
				+"}";
	}

}
