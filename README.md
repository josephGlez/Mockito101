# Junit 101
*`@Test`* - Marks the method as a test method.  
*`@Before`* and *`@After`* sandwiches each test method in the class.  
*`@BeforeClass`* and *`@AfterClass`* sandwiches all of the test methods in a JUnit test class.  

So when you run the JUnit test class below, the execution order is:  
Method annotated with *`@BeforeClass`*.     
Method annotated with *`@Before`*.   
First method annotated with *`@Test`* i.e. test1().  
Method annotated with *`@After`*.  
Method annotated with *`@Before`*.  
Second method annotated with *`@Test`* i.e. test2().  
Method annotated with *`@After`*.  
Method annotated with *`@AfterClass`*.  

# Mockito 101 
**Mock**:  This a dummy implementation for an interface or a class in which you define the output of certain method calls. Mock objects are configured to perform a certain behavior during a test. They typically record the interaction with the system and tests can validate that.  
When Mockito creates a mock – it does so from the Class of an Type, not from an actual instance. The mock simply creates a bare-bones shell instance of the Class, entirely instrumented to track interactions with it.  
Given that a mock contains no implementation details the output of its methods must be stubbed.  If a stub is not present mockito will return default values for the return data type.  
* null for objects  
* 0 for numbers  
* false for boolean  
* empty collections for collections  

**Spy** : This is an object that has real answers but also tracks interactions made with the object.  
The spy will wrap an existing instance. It will still behave in the same way as the normal instance – the only difference is that it will also be instrumented to track all the interactions with it.

**Verify** : Verify in Mockito simply means that you want to check if a certain method of a mock object has been called by specific number of times.  

**ArgumentCaptor** is used to capture arguments for mocked methods. ArgumentCaptor is used with Mockito verify() methods to get the arguments passed when any method is called.

# Lets Jump in
### How do I enable my test to run with mockito?
Simple, add the '*@RunWith(MockitoJUnitRunner.class)*' annotation above your test class.  
This provides a level of validation when running your tests, for example it makes sure you call .thenReturn when you stub a Mockito.when(... and also makes sure you specify a method call when using verify(<mock>).
  
### When Should I create a mock object?
You should create a mock object when the unit under test has external dependencies. Do not create a mock for value objects. If initializing the value object becomes cumbersome, try using the builder pattern or a shared function.

### How do I create a mock object?
Create your mock by annotation the field to be mocked with @Mock. This can be a class or an interface. 

### How does the unit under test know how to use my mock?
Once your mocks are defined you will inject your mocks by using the @InjectMock annotation. This is a field level annotation meant to be used above the class under test.  Some magic is involved, mockito will inject the properties using constructor, setter and field injection (in that order). If you have multiple datatypes for the mocked object, it will attempt to inject by matching the field name and mock name, usually not the case though.

### How do I know if I need a '*@before*', '*@after*'?
You shouldn't create these methods off the bat.  If you find yourself repeating setup or clean up, then you have a perfect candidate for these functions.

