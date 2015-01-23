package cn.zsy.utilJar;

import cn.zsy.vo.User;
import org.codehaus.jackson.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JacksonMain {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

//        1.1 Simple Data Binding
        simpleDataBinding(mapper);

        // 1.2 Full Data Binding
		fullDataBinding(mapper);

        // 1.3 Data Binding with Generics
//		dataBindingWithGenerics(mapper);

        // 1.4 Data Binding with Annotation
		dataBindingWithAnnotation(mapper);

        // 2.1 Tree Model
		treeModel(mapper);

        // 2.2 Construct a Tree
//		constructTreeModel(mapper);

        // 3.1 Streaming API (write Json)
//		streamingAPIWrite();

        // 3.2 Streaming API (read Json)
        streamingAPIRead();
    }

    @SuppressWarnings("unchecked")
    public static void simpleDataBinding(ObjectMapper mapper) throws Exception {
        String clientJsonBody = "{\"order\":\"0\",\"money\":\"100\",\"account\":\"0\",\"date\":\"2014-11-28 ~ 2014-11-28\"}";
        // json -> Map
//		Map<String, Object> userDataRead = mapper.readValue(new File("user.json"), Map.class);  //从文件读
        Map<String, Object> userDataRead = mapper.readValue(clientJsonBody, Map.class);
        System.out.println("simpleDataBinding(): map tostring--->" + userDataRead);

        // Map -> json
        Map<String, Object> userData = new HashMap<String, Object>();
        Map<String, String> nameStruct = new HashMap<String, String>();
        nameStruct.put("name1", "songyang");
        nameStruct.put("name2", "xieshihui");
        userData.put("wife", nameStruct);
        userData.put("gender", "MALE");
        userData.put("verified", Boolean.FALSE);
        userData.put("userImage", "Rm9vYmFyIQ==");
//		mapper.writeValue(new File("user-modified.json"), userData); //讲数据写入文件
        String mapStr = mapper.writeValueAsString(userData);
        System.out.println(mapStr);
    }

    public static void fullDataBinding(ObjectMapper mapper) throws Exception {
        String userJSON = "{\"id\":\"1\", \"name\":\"song_yang\", \"sex\":\"boy\"}";
        // json -> Object
//		User user = mapper.readValue(new File("user.json"), User.class);
        User user = mapper.readValue(userJSON, User.class);
        System.out.println("fullDataBinding(): bean---->" + user.toString());

        // Object -> json
//		mapper.writeValue(new File("user-modified.json"), user);
        String userStr = mapper.writeValueAsString(user);
        System.out.println(userStr);
    }

//    public static void dataBindingWithGenerics(ObjectMapper mapper) throws Exception {
//        String userJSON = "{\"id\":\"1\", \"name\":\"song_yang\", \"sex\":\"boy\"}";
//        // json -> Map
//		Map<String, Name> genericData = mapper.readValue(new File("generic.json"), new TypeReference<Map<String,Name>>() { });
////        Map<String, Name> genericData = mapper.readValue(userJSON, new TypeReference<Map<String, Name>>() {});
//
//        System.out.println("dataBindingWithGenerics():" + genericData);
//    }

    public static void dataBindingWithAnnotation(ObjectMapper mapper) throws Exception {
        String userJSON = "{\"id\":\"1\", \"name\":\"song_yang\", \"sex\":\"boy\"}";
        // json -> Object
//		Account account = mapper.readValue(new File("account.json"), Account.class);
        User user = mapper.readValue(userJSON, User.class);
        System.out.println("dataBindingWithAnnotation(): " + user);

        user.setName("xieshihui");
        // Object -> json
//		mapper.writeValue(new File("account.json"), account);
        String userStr = mapper.writeValueAsString(user);
        System.out.println(userStr);
    }

    public static void treeModel(ObjectMapper mapper) throws Exception {
        String userJSON = "{\"verified\":false,\"name\":{\"last\":\"Sixpack\",\"first\":\"Joe\"},\"userImage\":\"Rm9vYmFyIQ==\",\"gender\":\"MALE\"}";
        // can either use mapper.readTree(JsonParser), or bind to JsonNode
//		JsonNode rootNode = mapper.readValue(new File("user.json"), JsonNode.class);
        JsonNode rootNode = mapper.readValue(userJSON, JsonNode.class);

        // ensure that "last name" isn't "Xmler"; if is, change to "Jsoner"
        JsonNode nameNode = rootNode.path("name");
        String lastName = nameNode.path("last").getTextValue();
        System.out.println(lastName);
        if ("Sixpack".equalsIgnoreCase(lastName)) {
            ((ObjectNode) nameNode).put("last", "Jsoner");
        }
        // write it out
//		mapper.writeValue(new File("user-modified.json"), rootNode);
        mapper.writeValueAsString("---->" + rootNode.getTextValue());
    }

//	public static void constructTreeModel(ObjectMapper mapper) throws Exception {
//		ObjectMapper objectMapper = new ObjectMapper();
//		ObjectNode userOb = objectMapper.createObjectNode();
//		ObjectNode nameOb = userOb.putObject("name");
//		nameOb.put("first", "Thomas");
//		nameOb.put("last", "Zhou");
//		userOb.put("gender", User.Gender.MALE.toString());
//		userOb.put("verified", false);
//		userOb.put("userImage", "Foobar!".getBytes());
//		// write it out
//		mapper.writeValue(new File("user-modified.json"), userOb);
//	}

    public static void streamingAPIRead() throws Exception {
        JsonFactory f = new JsonFactory();
        JsonGenerator g = f.createJsonGenerator(new File("user.json"), JsonEncoding.UTF8);
        g.writeStartObject();
        g.writeObjectFieldStart("name");
        g.writeStringField("first", "Thomas");
        g.writeStringField("last", "Zhou");
        g.writeEndObject(); // for field 'name'
        g.writeStringField("gender", "333");
        g.writeBooleanField("verified", false);
        g.writeFieldName("userImage"); // no 'writeBinaryField' (yet?)
        byte[] binaryData = "Foobar!".getBytes();
        g.writeBinary(binaryData);
        g.writeFieldName("bababa");
//        g.writeString("xieshihui");
        g.writeNumber(22);
        g.writeEndObject();
        g.close(); // important: will force flushing of output, close underlying output stream
    }

//    public static void streamingAPIWrite() throws Exception {
//        JsonFactory f = new JsonFactory();
//        JsonParser jp = f.createJsonParser(new File("user.json"));
//        User user = new User();
//        jp.nextToken(); // will return JsonToken.START_OBJECT (verify?)
//        while (jp.nextToken() != JsonToken.END_OBJECT) {
//            String fieldname = jp.getCurrentName();
//            jp.nextToken(); // move to value, or START_OBJECT/START_ARRAY
//            if ("name".equals(fieldname)) { // contains an object
//                Name name = new Name();
//                while (jp.nextToken() != JsonToken.END_OBJECT) {
//                    String namefield = jp.getCurrentName();
//                    jp.nextToken(); // move to value
//                    if ("first".equals(namefield)) {
//                        name.setFirst(jp.getText());
//                    } else if ("last".equals(namefield)) {
//                        name.setLast(jp.getText());
//                    } else {
//                        throw new IllegalStateException("Unrecognized field '" + fieldname + "'!");
//                    }
//                }
//                user.setName(name);
//            } else if ("gender".equals(fieldname)) {
//                user.setGender(User.Gender.valueOf(jp.getText()));
//            } else if ("verified".equals(fieldname)) {
//                user.setVerified(jp.getCurrentToken() == JsonToken.VALUE_TRUE);
//            } else if ("userImage".equals(fieldname)) {
//                user.setUserImage(jp.getBinaryValue());
//            } else {
//                throw new IllegalStateException("Unrecognized field '" + fieldname + "'!");
//            }
//        }
//        jp.close(); // ensure resources get cleaned up timely and properly
//        System.out.println("streamingAPIWrite(): " + user);
//    }

}
