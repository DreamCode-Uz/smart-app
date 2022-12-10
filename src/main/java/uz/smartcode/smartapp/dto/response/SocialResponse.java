package uz.smartcode.smartapp.dto.response;

import lombok.Data;
import uz.smartcode.smartapp.entity.Social;

@Data
public class SocialResponse {
    private final Integer id;
    private final String name;
    private final String url;

    public SocialResponse(Social social) {
        this.id = social.getId();
        this.name = social.getName();
        this.url = social.getUrl();
    }
}
