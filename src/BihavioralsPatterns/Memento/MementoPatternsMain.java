package BihavioralsPatterns.Memento;

public class MementoPatternsMain {
    public static void main(String[] args) throws InterruptedException {
        Project project = new Project();
        GitHubRepo gitHubRepo = new GitHubRepo();

        System.out.println("Create new project. Version: 1.0");
        project.setVersionAndDate("Version 1.0");

        System.out.println(project);

        System.out.println("Saving current version to github...");
        gitHubRepo.setSave(project.save());

        System.out.println("Updating project to Version 1.1");

        System.out.println("Write code...");
        Thread.sleep(5000);

        project.setVersionAndDate("Version 1.1");

        System.out.println(project);

        System.out.println("Something went wrong...");

        System.out.println("Rolling back to version 1.0");
        project.load(gitHubRepo.getSave());

        System.out.println("Acting after rollback: ");

        System.out.println(project);
    }
}
