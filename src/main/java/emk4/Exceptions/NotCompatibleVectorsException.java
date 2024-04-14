package emk4.Exceptions;

public class NotCompatibleVectorsException extends Exception{
    public NotCompatibleVectorsException() {
        super("[ERROR]: Vectors are not compatible to perform this operation.");
    }
}
