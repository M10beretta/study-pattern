package command.baeldung;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class TextFile {
    private final String name;

    public String open() {
        return "Opening file " + name;
    }

    public String save() {
        return "Saving file " + name;
    }
}
