package OOPPreparationExams.ExamOne.picking.core;

import picking.entities.action.Action;
import picking.entities.action.ActionImpl;
import picking.entities.pickers.ExperiencedPicker;
import picking.entities.pickers.JuniorPicker;
import picking.entities.pickers.Picker;
import picking.entities.places.Place;
import picking.entities.places.PlaceImpl;
import picking.repositories.PlaceRepository;
import picking.repositories.Repository;

import java.util.Collection;
import java.util.List;

import static picking.common.ConstantMessages.*;
import static picking.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private final Repository<Place> placeRepository;

    public ControllerImpl() {
        this.placeRepository = new PlaceRepository();
    }

    @Override
    public String addPlace(String placeName, String... mushrooms) {
        Place place = new PlaceImpl(placeName);
        place.getMushrooms().addAll(List.of(mushrooms));
        this.placeRepository.add(place);

        return String.format(PLACE_ADDED, placeName);
    }

    @Override
    public String addPicker(String placeName, String pickerType, String pickerName) {
        Place place = placeRepository.byName(placeName);

        Picker picker = place.getPickers().stream().filter(p -> p.getName().equals(pickerName)).findFirst().orElse(null);

        if (picker != null) {
            throw new IllegalArgumentException(EXISTING_PICKER);
        }

        Picker pickerToAdd = switch (pickerType) {
            case "JuniorPicker" -> new JuniorPicker(pickerName);
            case "ExperiencedPicker" -> new ExperiencedPicker(pickerName);
            default -> throw new IllegalArgumentException(INVALID_PICKER);
        };

        place.getPickers().add(pickerToAdd);


        return String.format(PICKER_ADDED, pickerType, pickerName);
    }

    @Override
    public String startPicking(String placeName) {
        Place place = placeRepository.byName(placeName);

        if (place == null){
            throw new NullPointerException(String.format(NON_EXISTING_PLACE, placeName));
        }

        Action action = new ActionImpl();
        action.startPicking(place);

        return String.format(PLACE_VISITED, placeName);
    }

    @Override
    public String getStatistics() {

        StringBuilder builder = new StringBuilder();

        Collection<Place>places = placeRepository.getCollection();
        for (Place place : places) {
            builder.append(String.format("Pickers in the %s:",place.getName())).append(System.lineSeparator());
            for (Picker picker : place.getPickers()) {
                builder.append(String.format("Name: %s",picker.getName())).append(System.lineSeparator())
                        .append(String.format("Vitality: %d", picker.getVitality())).append(System.lineSeparator());

                Collection<String> mushrooms = picker.getBag().getMushrooms();
                if (mushrooms.isEmpty()){
                    builder.append("Bag mushrooms: none").append(System.lineSeparator());
                }else {
                    builder.append(String.format("Bag mushrooms: %s", String.join(", ", mushrooms))).append(System.lineSeparator());
                }
            }

        }

        return builder.toString();
    }



}
