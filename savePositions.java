import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @PostMapping("/positions")
    public ResponseEntity<?> savePositions(@RequestBody PositionRequest request) {
        // Логика сохранения данных
        if (request.getParentIdentifier() == null || request.getParentType() == null || request.getPositions().isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid request data");
        }

        for (Position position : request.getPositions()) {
            if (position.getPositionName() == null || position.getNomenclature() == null) {
                return ResponseEntity.badRequest().body("Position data is invalid");
            }
            // Дополнительная логика сохранения
        }

        return ResponseEntity.ok("Positions saved successfully");
    }
}

// Классы для обработки запроса

class PositionRequest {
    private Integer parentIdentifier;
    private String parentType;
    private List<Position> positions;

    // Геттеры и сеттеры
    public Integer getParentIdentifier() {
        return parentIdentifier;
    }

    public void setParentIdentifier(Integer parentIdentifier) {
        this.parentIdentifier = parentIdentifier;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}

class Position {
    private String positionName;
    private String positionType;
    private Integer positionOrder;
    private Nomenclature nomenclature;
    private Boolean isComplementary;
    private List<ProductModel> productModels;
    private String gammaLetter;
    private String qartel;
    private List<Integer> commercialItem;

    // Геттеры и сеттеры
}

class Nomenclature {
    private Integer departmentId;
    private Integer subDepartmentId;
    private Integer typeId;
    private Integer subTypeId;

    // Геттеры и сеттеры
}

class ProductModel {
    private String modelIdentifier;
    private String characteristicIdentifier;
    private List<CharacteristicValue> characteristicsValues; // Значения характеристики

    // Геттеры и сеттеры
}

class CharacteristicValue {
    private String characteristicValue;
    private String characteristicValueIdentifier;
    private String characteristicMinValue;
    private String characteristicMaxValue;

    // Геттеры и сеттеры
}
