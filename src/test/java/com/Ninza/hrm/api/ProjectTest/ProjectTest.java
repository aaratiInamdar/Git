package com.Ninza.hrm.api.ProjectTest;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Ninza.hrm.BaseClass.BaseAPIClass;
import com.Ninza.hrm.EndPoints.IEndPoint;
import com.Ninza.hrm.PojoClassUtility.ProjectPojo;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.util.ArrayList;



public class ProjectTest extends BaseAPIClass{

	ProjectPojo pObj;
	
	@Test
	public void addSingleProjectWithCreated() throws IOException
	{
	
		String expSuccesMsg="Successfully Added";
		String	 projectName="Orange"+ju.getRandomNumber(300);
		
		
		 pObj=new ProjectPojo(projectName, "Created", "Aarati", 0);
		
		
//		Verify the ProjectName in API layer 
		Response response = given()
								.spec(specRequestObj)								
								.body(pObj)
								
								.when()
								.post( IEndPoint.addProject);
								
					response.then()
								.assertThat().statusCode(201)
								.assertThat().time(Matchers.lessThan(3000l))
								.spec(specResponseObj)
								.log().all();
								String actSuccesMsg = response.jsonPath().get("msg");
								Assert.assertEquals(expSuccesMsg, actSuccesMsg);
								
				//	  Verify the ProjectName in DataBase layer 
				// we don't have access to the database 
																
	}
	
			@Test(dependsOnMethods = "addSingleProjectWithCreated")
			public void createDuplicateProjectTest() throws IOException
			{
				String BaseUri = fu.getDataFromProperties("BASEURI");

				 given()
						.spec(specRequestObj)
						.body(pObj)
						
			    .when()
						.post(IEndPoint.addProject)
						
				.then()
						.spec(specResponseObj)
						.assertThat().statusCode(409)
						.log().all();	
				 
				 
				 				
       }
			
			
}
