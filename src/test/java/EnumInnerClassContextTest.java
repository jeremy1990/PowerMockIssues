import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

public class EnumInnerClassContextTest {
    @Test
    @PrepareForTest({EnumInnerClassContext.class, CreationInEnumInnerClass.class})
    public void testToBeOverriden() throws Exception {
        final CreationInEnumInnerClass innerClass = Mockito.mock(CreationInEnumInnerClass.class);
        PowerMockito.whenNew(CreationInEnumInnerClass.class).withNoArguments().thenReturn(innerClass);
        Mockito.when(innerClass.isCorrect(Mockito.anyString())).thenReturn(false);

        // Expect the false branch will be executed, but actually the instrumentation is not correct
        // EnumInnerClassContext.MEMBER1 seems to be a subclass of EnumInnerClassContext, thus the
        // classes prepared is not correct.
        EnumInnerClassContext.MEMBER1.toBeOverriden();
    }
}
