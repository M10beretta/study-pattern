package visitor.husivm;

class Cat implements Animal {
    @Override
    public void voice(Visitor v) {
        v.voiceCat();
    }
}
