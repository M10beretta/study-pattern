package command.baeldung;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class SaveTextFileOperation implements TextFileOperation {
    private final TextFile textFile;

    @Override
    public String execute() {
        return textFile.save();
    }
}
