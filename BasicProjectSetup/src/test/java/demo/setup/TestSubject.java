package demo.setup;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * @author dinesh.joshi
 *
 */
public class TestSubject {

  /**
   * 
   */
  @Test
  public void TestSubject() {
    Subject engSubject = new Subject("English", "1");

    Object[] expecteds = new Object[2];
    expecteds[0] = "English";
    expecteds[0] = "1";

    Object[] actuals = new Object[2];
    actuals[0] = engSubject.getSubName();
    actuals[0] = engSubject.getSubId();
    assertArrayEquals(expecteds, actuals);

  }

}
