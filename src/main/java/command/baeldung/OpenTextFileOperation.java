package command.baeldung;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class OpenTextFileOperation implements TextFileOperation {
    private final TextFile textFile;

    @Override
    public String execute() {
        return textFile.open();
    }
}
