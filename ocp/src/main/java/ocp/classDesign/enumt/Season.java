/**
 * 
 */
package ocp.classDesign.enumt;

/**
 * @author edinjos
 *
 */
public enum Season {

  WINTER("LOW") {

    @Override
    public void printhours() {
      Season.SPRING.printhours();

    }

    @Override
    public void testFUN() {
      System.out.println("WINTER Inside enum value function");
    }
  },
  SPRING("MEDIUM") {
    @Override
    public void printhours() {
      System.out.println("SPRING printhours");

    }
  },
  SUMMER("HIGH") {
    @Override
    public void printhours() {
      // TODO Auto-generated method stub

    }
  },
  FALL("MEDIUM") {
    @Override
    public void printhours() {
      // TODO Auto-generated method stub

    }
  };
  private static int i;
  private String intensity;

  Season(String s) {
    System.out.println("Parameterized Constructor " + s);
    intensity = s;
  }

  public abstract void printhours();

  public void testFUN() {
    System.out.println("Inside enum function");
  }

  public static void main(String... varArgs) {
    System.out.println("Running main ");
    for (Season s : Season.values()) {
      System.out.println(s.ordinal() + " " + s.name() + " ");
    }

    Season summer = Season.SUMMER;

    System.out.println(summer + " " + summer.intensity + " " + summer.name() + " " + summer.toString());

    switch (summer) {
    case WINTER:
      System.out.println("It is winter");
      break;
    case SPRING:
      System.out.println("It is spring");
      break;
    case SUMMER:
      System.out.println("It is summer");
      break;
    case FALL:
      System.out.println("It is fall");
      break;
    }

    Season.WINTER.testFUN();
    Season.SPRING.testFUN();
    Season.SPRING.printhours();

    System.out.println("\n\n\n");

    for (SftpParameters s : SftpParameters.values()) {
      System.out.print(s.ordinal() + " " + s.name() + " " + s.getDescription());

      if (String.class.equals(s.getType())) {
        System.out.println(" String");
      } else if (Boolean.class.equals(s.getType())) {
        System.out.println(" Boolean");
      } else {
        System.out.println("Not configured.");
      }
    }
  }

}

enum SftpParameters {
  URL("SFTP URL") {
    @Override
    public Object getType() {
      // TODO Auto-generated method stub
      return String.class;
    }
  },
  USERNAME("SFTP USERNAME") {
    @Override
    public Object getType() {
      // TODO Auto-generated method stub
      return String.class;
    }
  },
  AUTHENTICATION("SFTP PEM LOCATION") {
    @Override
    public Object getType() {
      // TODO Auto-generated method stub
      return String.class;
    }
  },
  LOCAL("SFTP LOCAL DIRECTORY") {
    @Override
    public Object getType() {
      // TODO Auto-generated method stub
      return String.class;
    }
  },
  REMOTE("SFTP REMOTE DIRECTORY") {
    @Override
    public Object getType() {
      // TODO Auto-generated method stub
      return String.class;
    }
  },
  REMOTE_FILE("SFTP REMOTE FILENAME") {
    @Override
    public Object getType() {
      // TODO Auto-generated method stub
      return String.class;
    }
  },
  DIR_COPY("SFTP REMOTE DIRECTORY COPY") {
    @Override
    public Object getType() {
      // TODO Auto-generated method stub
      return Boolean.class;
    }
  },
  STRICT_CHECK("SFTP HOSTNAME STRICT CHECK") {
    @Override
    public Object getType() {
      // TODO Auto-generated method stub
      return Boolean.class;
    }
  },
  BACKUP("SFTP BACKUP FILENAME") {
    @Override
    public Object getType() {
      // TODO Auto-generated method stub
      return String.class;
    }
  };

  private String description;

  public abstract Object getType();

  SftpParameters(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}