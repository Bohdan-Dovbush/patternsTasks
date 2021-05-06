package BihavioralsPatterns.Iterator;

class SkillIterator implements Iterator {

    private final JavaDeveloper javaDeveloper;
    private int index;

    public SkillIterator(JavaDeveloper javaDeveloper) {
        this.javaDeveloper = javaDeveloper;
    }

    @Override
    public boolean hasNext() {
        return index < javaDeveloper.skills.length;
    }

    @Override
    public Object next() {
        return javaDeveloper.skills[index++];
    }
}
