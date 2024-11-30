@MyAnnotation(value = "Class Annotation Example", version = 2)
public class AnnotatedClass {

    @MyAnnotation(value = "Method Annotation Example", version = 3)
    public void annotatedMethod() {
        System.out.println("Annotated method is called!");
    }
}
